package com.amondel.idsub

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class IdeaVotesController {

    static scaffold = IdeaVotes
}
