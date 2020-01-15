package com.amondel.idsub

class Tag extends AbstractDomainObject {

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

    static hasMany = [tagIdeas: TagIdea]


    String name
}
