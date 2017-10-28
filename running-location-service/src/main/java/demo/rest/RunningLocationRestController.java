package demo.rest;

import demo.domain.Location;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningLocationRestController {

    private LocationService locationService;

    @Autowired
    public RunningLocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }


    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Location> runningLocations) {
        this.locationService.saveRunningLocations(runningLocations);
    }


    @RequestMapping(value = "/running", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge() {
        this.locationService.deleteAll();
    }


    //cs504.com/running/STOPPED?page=0&size=10
    //STOPPED is PathVariable, page and size are RequestParam
    @RequestMapping(value = "/running/{movementType}", method = RequestMethod.GET)
    public Page<Location> findByMovementType(@PathVariable String movementType, @RequestParam("page") int page,
                                             @RequestParam("size") int size) {
        return locationService.findByRunnerMovementType(movementType, new PageRequest(page, size));
    }

    /*findByRunningId() {

    }*/
}
