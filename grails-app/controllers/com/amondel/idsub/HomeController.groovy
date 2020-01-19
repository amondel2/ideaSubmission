package com.amondel.idsub

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class HomeController {

    UserService userService
    SpringSecurityService springSecurityService

    def index() {
        render(view:"index",model:[param:params,messages:[]])
    }

    def getMyIdeas(){
        def rtn = [:]
        try {
            rtn = userService.getIdeas(springSecurityService.getCurrentUser())
        } catch(Exception e) {
            rtn.error = e.getMessage()
        }
        withFormat {
            '*' {
                render([msg: rtn] as JSON)
            }
        }
    }

    def getLatestIdeas(){
        def rtn = [:]
        try {
            rtn = userService.getLatestIdeas()
        } catch(Exception e) {
            rtn.error = e.getMessage()
        }
        withFormat {
            '*' {
                render([msg: rtn] as JSON)
            }
        }
    }
}