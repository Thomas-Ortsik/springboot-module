package academy.everyonecodes.singaporereconstruction.beans;

import academy.everyonecodes.singaporereconstruction.data.Building;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnaliser {
    private List<Building> buildings;

    void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates() {
        LocalDate currentDate = LocalDate.now();
        LocalDate cutOffForRebuild = currentDate.minusYears(20);
        return buildings.stream()
                .filter(building -> !building.isHistoric() && building.getBuilt().isBefore(cutOffForRebuild))
                .collect(Collectors.toList());
    }
}
