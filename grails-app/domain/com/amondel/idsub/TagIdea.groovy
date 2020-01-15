package com.amondel.idsub

class TagIdea extends AbstractDomainObject {


    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
    }


    @Override
    String toString() {
        return "${this?.tag?.toString()} ${this.idea?.toString()}"
    }

    static belongsTo = [tag: Tag, idea: Idea]


    Tag tag
    Idea idea

}