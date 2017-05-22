package com.marketplace.propertiesservice.web;

import com.marketplace.propertiesservice.backend.SearchService;
import com.marketplace.propertiesservice.model.Contract;
import com.marketplace.propertiesservice.model.Search;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/users/{userId}/searches")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    @ResponseBody
    public List<Search> find(@RequestParam Optional<Integer> bedrooms,
                             @RequestParam Optional<BigDecimal> price,
                             @RequestParam Optional<Contract.Type> contractType) {
        return searchService.find(bedrooms, price, contractType);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Search create(@PathVariable String userId, @RequestBody Search search) {
        search.setUserId(userId);
        return searchService.create(search);
    }

    @PutMapping
    @ResponseBody
    public Search update(@RequestBody Search search) {
        return searchService.update(search);
    }

    @GetMapping("{searchId}")
    @ResponseBody
    public Search get(@PathVariable String searchId) {
        return searchService.get(searchId);
    }

    @DeleteMapping("{searchId}")
    public void delete(@PathVariable String searchId) {
        searchService.delete(searchId);
    }
}
