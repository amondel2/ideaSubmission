package com.amondel.idsub

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED

@Secured(['ROLE_USER'])
class IdeaController {
    static scaffold = Idea
    IdeaService ideaService
    SpringSecurityService springSecurityService

    def createUser() {
        respond new Idea(params)
    }

    def saveUser(Idea idea) {
        if (idea == null) {
            notFound()
            return
        }
        try {
            idea.user = springSecurityService.getCurrentUser()
            ideaService.save(idea)
        } catch (ValidationException e) {
            respond idea.errors, view:'createUser'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idea.label', default: 'Idea'), idea.title])
                redirect controller:'Home'
            }
            '*' { respond idea, [status: CREATED] }
        }
    }
}