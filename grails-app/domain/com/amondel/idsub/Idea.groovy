package com.amondel.idsub

class Idea extends AbstractDomainObject {


    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
        description type: 'text'
    }

    @Override
    String toString() {
        return this.title
    }

    static hasMany = [tags: TagIdea, votes:IdeaVotes]
    static belongsTo = [status: Status]
    String title
    String description
    Status status
}