package com.amondel.idsub

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class TagController {
    static scaffold = Tag
}