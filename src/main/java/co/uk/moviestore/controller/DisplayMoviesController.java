package co.uk.moviestore.controller;

import co.uk.moviestore.controller.url.RequestUrl;
import co.uk.moviestore.model.VideoRental;
import co.uk.moviestore.service.IMoviesService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Display Movies Controller
 *
 * @author Benjamin O'Flaherty
 * @date Created on: 23/01/2015
 * @project MovieStore
 */
@Controller
public class DisplayMoviesController {

    @Autowired
    private IMoviesService service;

    @RequestMapping(value = RequestUrl.displayAllMovies, method = RequestMethod.GET)
    public ModelAndView displayAllAvailableMovies(ModelAndView mav) {

        service.retrieveAllAvailableMovies();

        List<VideoRental> allMoviesList = new ArrayList();

        VideoRental videoRental = new VideoRental();
        videoRental.setId(1L);
        videoRental.setTitle("movie title");
        videoRental.setCategory("action");
        videoRental.setCheckOut(new DateTime());
        videoRental.setReturnDate(new DateTime());

        allMoviesList.add(videoRental);

        mav.addObject("allMoviesList", allMoviesList);

        return mav;
    }

}
