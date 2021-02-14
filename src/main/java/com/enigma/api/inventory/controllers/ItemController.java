package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.Item;
import com.enigma.api.inventory.entities.Unit;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.ImageUploadRequest;
import com.enigma.api.inventory.models.PagedList;
import com.enigma.api.inventory.models.items.ItemElement;
import com.enigma.api.inventory.models.items.ItemRequest;
import com.enigma.api.inventory.models.items.ItemResponse;
import com.enigma.api.inventory.models.items.ItemSearch;
import com.enigma.api.inventory.services.FileService;
import com.enigma.api.inventory.services.ItemService;
import com.enigma.api.inventory.services.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.filters.ExpiresFilter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UnitService unitService;

    @Autowired
    private FileService fileService;

    @Operation(summary = "Show data item by id", tags = {"ITEM"}, description = "Show data by id")
    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Item entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Show all item data", tags = {"ITEM"}, description = "Show all item")
    @GetMapping
    public ResponseMessage<PagedList<ItemElement>> findAll(
            @Valid ItemSearch model
    ) {
        Item search = modelMapper.map(model, Item.class);

        Page<Item> entityPage = service.findAll(search, model.getPage(), model.getSize(), model.getSort());
        List<Item> entities = entityPage.toList();

        List<ItemElement> models = entities.stream()
                .map(e -> modelMapper.map(e, ItemElement.class))
                .collect(Collectors.toList());

        PagedList<ItemElement> data = new PagedList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());
        return ResponseMessage.success(data);
    }

//    @PostMapping("/with-unit")
//    public ResponseMessage<ItemResponse> addWithUnit(@RequestBody @Valid ItemResponse model) {
//        Item entity = modelMapper.map(model, Item.class);
//
//        entity = service.addItemWithUnit(entity);
//
//        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
//        return ResponseMessage.success(data);
//    }

    @Operation(summary = "Add Item", tags = {"ITEM"}, description = "You can insert name and price")
    @PostMapping
    public ResponseMessage<ItemResponse> add(@RequestBody @Valid ItemRequest model) {
        Item entity = modelMapper.map(model, Item.class);

        entity.setUnit(unitService.findById(model.getUnitId()));



        entity = service.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit item", tags = {"ITEM"}, description = "You can edit name and price")
    @PutMapping("/{id}")
    public ResponseMessage<ItemResponse> edit(
            @PathVariable Integer id, @RequestBody @Valid ItemRequest model) {
        Item entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        model = getRequest(model, entity);
        modelMapper.map(model,entity);

        entity = service.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }
    @Operation(summary = "Delete Permanently", tags = {"ITEM"}, description = "CAREFULL, you are about to delete data permanently")
    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        Item entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }
    @Operation(summary = "Upload ", tags = {"ITEM"}, description = "some description")
    @PostMapping(value = "/{id}/upload", consumes = "multipart/form-data")
    public ResponseMessage upload(@PathVariable Integer id, @Valid ImageUploadRequest model) throws IOException {
        Item entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        fileService.upload(entity, model.getFile().getInputStream());

        return ResponseMessage.success(true);
    }
    @Operation(summary = "Download", tags = {"ITEM"}, description = "some description")
    @GetMapping("/{id}/download")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {

        Item entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename=\""+entity.getId()+"\"");
        fileService.download(entity, response.getOutputStream());
    }

    public ItemRequest getRequest(ItemRequest request, Item item){
        if(request.getName()==null) request.setName(item.getName());
        if(request.getPrice()==null) request.setPrice(item.getPrice());
        if(request.getUnitId()==null) request.setUnitId(item.getUnit().getId());
        item.setUnit(unitService.findById(request.getUnitId()));
        return request;
    }
}
