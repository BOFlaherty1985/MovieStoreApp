package co.uk.moviestore.controller;

import co.uk.moviestore.config.ApplicationConfig;
import co.uk.moviestore.config.WebInitializer;
import co.uk.moviestore.service.IMoviesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Display Movies Controller Test Class
 *
 * @author Benjamin O'Flaherty
 * @date Created on: 23/01/2015
 * @project MovieStore
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, WebInitializer.class})
@WebAppConfiguration
public class DisplayMoviesControllerTest {

    /*  As a user I want to view all available movie rentals so that I can make a choice of which movie to rent */

    private MockMvc mockMvc;

    @Autowired
    @InjectMocks
    private DisplayMoviesController controller;
    @Mock
    private IMoviesService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver)
                .build();

    }

    @Test
    public void displayAllAvailableMovies_statusCode_isEqualToOk() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(status().isOk());

    }

    @Test
    public void displayAllAvailableMovies_return_isNotNull() throws Exception {

        assertNotNull(mockMvc.perform(get("/displayAllAvailableMovies"))
                .andReturn());

    }

    @Test
    public void displayAllAvailableMovies_viewEquals_displayAllMovies() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(view().name("displayAllAvailableMovies"))
                .andExpect(status().isOk());

    }

    @Test
    public void displayAllAvailableMovies_serviceInterface_calledOnce() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(view().name("displayAllAvailableMovies"))
                .andExpect(status().isOk());

        Mockito.verify(service, times(1)).retrieveAllAvailableMovies();

    }

    @Test
    public void displayAllAvailableMovies_modelContains_allMoviesList() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(model().attributeExists("allMoviesList"))
                .andExpect(view().name("displayAllAvailableMovies"))
                .andExpect(status().isOk());

    }

    @Test
    public void displayAllAvailableMovies_allMoviesList_sizeEqualsOne() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(model().attribute("allMoviesList", hasSize(1)))
                .andExpect(view().name("displayAllAvailableMovies"))
                .andExpect(status().isOk());

    }

    @Test
    public void displayAllAvailableMovies_allMoviesList_videoRentalHasCorrectProperties() throws Exception {

        mockMvc.perform(get("/displayAllAvailableMovies"))
                .andExpect(model().attribute("allMoviesList", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("title", is("movie title")),
                                hasProperty("category", is("action")),
                                hasProperty("checkOut"),
                                hasProperty("returnDate")
                        )
                )))
                .andExpect(view().name("displayAllAvailableMovies"))
                .andExpect(status().isOk());

    }


}
