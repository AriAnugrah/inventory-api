package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.Item;
import com.enigma.api.inventory.entities.Stock;
import com.enigma.api.inventory.entities.StockSummary;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.PagedList;
import com.enigma.api.inventory.models.stocks.*;
import com.enigma.api.inventory.services.ItemService;
import com.enigma.api.inventory.services.StockService;
import com.enigma.api.inventory.services.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/stocks")
@RestController
public class StockController {

    @Autowired
    private StockService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UnitService unitService;


    @Operation(summary = "Search data by id", tags = {"STOCK"}, description = "Search data by id")
    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {

        Stock entity = service.findById(id);
        if (entity == null || !entity.isStatus()) {
            throw new EntityNotFoundException();
        }

        StockResponse data = modelMapper.map(entity, StockResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Search data", tags = {"STOCK"}, description = "Show data by id")
    @GetMapping
    public ResponseMessage<PagedList<StockElement>> findAll(
            @Valid StockSearch model
    ) {

        Stock search = modelMapper.map(model, Stock.class);

        Page<Stock> entityPage = service.findAll(search, model.getPage(), model.getSize(), model.getSort());
        List<Stock> entities = entityPage.toList();
        /*List<Stock> ee = new ArrayList<>();
        for (Stock s : entities) {
            if (s.isStatus() == true) ee.add(s);
        }*/
            entities = entities.stream().filter(a -> a.isStatus()).collect(Collectors.toList());

        List<StockElement> models = entities.stream()
                .map(e -> modelMapper.map(e, StockElement.class))
                .collect(Collectors.toList());

        PagedList<StockElement> data = new PagedList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());
        return ResponseMessage.success(data);

    }

    @Operation(summary = "Add stock", tags = {"STOCK"}, description = "add new stock")
    @PostMapping
    public ResponseMessage<StockResponse> add(@RequestBody @Valid StockRequest model) {
        Stock entity = modelMapper.map(model, Stock.class);

        /*Item item = itemService.findById(model.getItemId());
        entity.setTotalPrice(model.getQuantity() * item.getPrice());
        entity.setItem(item);*/

        entity = service.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "soft delete", tags = {"STOCK"}, description = "Delet temporary")
    @PutMapping("/softdelete/{id}")
    public ResponseMessage<StockResponse> softDelete(@PathVariable @Valid Integer id) {

        Stock entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        entity.setStatus(false);
        entity.setQuantity(0);


        entity = service.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);

        return ResponseMessage.success(data);
    }

    @Operation(summary = "Edit Stock", tags = {"STOCK"}, description = "You can edit quantity and item id")
    @PutMapping("/{id}")
    public ResponseMessage<StockResponse> edit(@PathVariable @Valid Integer id, @RequestBody StockRequest model) {

        Stock entity = service.findById(id);
        if (entity == null || !entity.isStatus()) {
            throw new EntityNotFoundException();
        }

        /*Item item = itemService.findById(model.getItemId());
        entity.setTotalPrice(model.getQuantity() * item.getPrice());
        entity.setItem(item);*/

        modelMapper.map(model, entity);
        entity = service.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);

        return ResponseMessage.success(data);
    }


    @Operation(summary = "Remove Permanently", tags = {"STOCK"}, description = "you will delete data permanently")
    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        Stock entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }

    @Operation(summary = "Summaries", tags = {"STOCK"}, description = "See summeries")
    @GetMapping("/summaries")
    public ResponseMessage<List<StockSummary>> findAllSummary() {
        List<StockSummary> entityPage = service.findAllSummaries();
        return ResponseMessage.success(entityPage);
    }

    @Operation(summary = "Purches", tags = {"STOCK"}, description = "Buy Here")
    @PostMapping("/transaction/{id}")
    public ResponseMessage<StockResponse> purches(@RequestBody @Valid StockRequest model) {
        Stock entity = modelMapper.map(model, Stock.class);

        Item item = itemService.findById(model.getItemId());
        entity.setTotalPrice(model.getQuantity() * item.getPrice());
        entity.setQuantity(0-entity.getQuantity());
        entity.setItem(item);

        entity = service.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }


}
