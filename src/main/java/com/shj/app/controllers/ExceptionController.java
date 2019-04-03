package com.shj.app.controllers;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.shj.app.exceptions.EleveExistantException;
import com.shj.app.exceptions.IdentifiantExistantException;
import com.shj.app.exceptions.IdentiteExistantException;
import com.shj.app.exceptions.ParamNullException;

@ControllerAdvice
public class ExceptionController {

    Logger                      logger          = LoggerFactory.getLogger( this.getClass() );

    // VIEWS
    private static final String VUE_PAGE_ERREUR = "error";

    // GESTIONNAIRE D'EXCEPTIONS
    @ExceptionHandler( { EleveExistantException.class, IdentifiantExistantException.class,
            IdentiteExistantException.class, ParamNullException.class, NullPointerException.class,
            ValidationException.class, DataIntegrityViolationException.class } )
    public ModelAndView HandleException( Exception exception ) {

        ModelAndView mv = new ModelAndView( VUE_PAGE_ERREUR );

        logger.error( exception.getMessage() );
        logger.error( null, exception.getStackTrace() );

        mv.addObject( "erreurMessage", exception.getMessage() );
        mv.addObject( "erreurType", exception.getClass().getSimpleName() );

        return mv;
    }

}
