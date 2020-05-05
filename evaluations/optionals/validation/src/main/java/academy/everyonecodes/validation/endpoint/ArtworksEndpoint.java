package academy.everyonecodes.validation.endpoint;

import academy.everyonecodes.validation.domain.Artwork;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/artworks")
@Validated
public class ArtworksEndpoint {

    @PostMapping
    Artwork post(@Valid Artwork artwork) {
        return artwork;
    }
}
