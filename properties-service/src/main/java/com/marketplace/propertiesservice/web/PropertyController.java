package com.marketplace.propertiesservice.web;

import com.marketplace.propertiesservice.backend.PropertyService;
import com.marketplace.propertiesservice.model.Contract;
import com.marketplace.propertiesservice.model.Property;
import com.marketplace.propertiesservice.search.Range;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/properties")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    @ResponseBody
    public List<Property> find(@RequestParam Optional<Integer> minimumBedrooms,
                               @RequestParam Optional<Integer> maximumBedrooms,
                               @RequestParam Optional<BigDecimal> minimumPrice,
                               @RequestParam Optional<BigDecimal> maximumPrice,
                               @RequestParam Optional<Contract.Type> contractType) {
        return propertyService.find(new Range<>(minimumBedrooms, maximumBedrooms),
            new Range<>(minimumPrice, maximumPrice), contractType);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Property create(@RequestBody Property property) {
        property.setId(null);
        return propertyService.create(property);
    }

    @PutMapping
    public Property update(@RequestBody Property property) {
        return propertyService.update(property);
    }

    @GetMapping("{propertyId}")
    @ResponseBody
    public Property get(@PathVariable String propertyId) {
        return propertyService.get(propertyId);
    }

    @DeleteMapping("{propertyId}")
    public void delete(@PathVariable String propertyId) {
        propertyService.delete(propertyId);
    }
}
