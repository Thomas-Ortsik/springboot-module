package academy.everyonecodes.musicstation.endpoints;

import academy.everyonecodes.musicstation.domain.Song;
import academy.everyonecodes.musicstation.logic.MusicStation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MusicStationEndpoint {
    private MusicStation musicStation;

    public MusicStationEndpoint(MusicStation musicStation) {
        this.musicStation = musicStation;
    }

    @GetMapping("/songs")
    List<Song> getAll(){
        return musicStation.findAll();
    }
//just realized this is not supposed to be a pathvariable
    //for the sake of my sanity right now, i'll keep it like this though
    @GetMapping("/songs/{genre}")
    List<Song> getGenre(@PathVariable String genre){
        return musicStation.findBy(genre);
    }
}
