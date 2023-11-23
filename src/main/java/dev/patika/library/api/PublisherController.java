package dev.patika.library.api;

import dev.patika.library.business.abstracts.IPublisherService;
import dev.patika.library.dao.PublisherRepo;
import dev.patika.library.dto.PublisherGetRequest;
import dev.patika.library.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class PublisherController {

    @Autowired
    private final IPublisherService publisherService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PublisherController (IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherGetRequest> findAll() {
        List<PublisherGetRequest> publisherGetRequestList = this.publisherService.findAll().stream().map(
                publisher -> this.modelMapper.map(publisher,PublisherGetRequest.class)
        ).collect(Collectors.toList());
        return publisherGetRequestList;
    }
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher) {
        return this.publisherService.save(publisher);
    }
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher) {
        return this.publisherService.update(publisher);
    }

    @DeleteMapping("/publishers/{id}")
    public void delete(@PathVariable("id")int id) {
        this.publisherService.delete(id);
    }

    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Publisher getById(@PathVariable ("id") int id) {
        return this.publisherService.getById(id);
    }
}
