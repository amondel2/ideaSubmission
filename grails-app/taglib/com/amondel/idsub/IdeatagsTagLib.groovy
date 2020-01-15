package com.amondel.idsub

class IdeatagsTagLib {
    static namespace="ps"
    def springSecurityService
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def getUserName = {attrs,body->
        def name =  springSecurityService?.currentUser?.username ?: ""
        out << body() <<name
    }
}
