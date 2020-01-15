package com.amondel.idsub

class Status extends AbstractDomainObject {

    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
    }

    @Override
    String toString() {
        return this.name
    }

    static hasMany = [ideas: Idea]

    String name
}
