package com.amondel.idsub

class Idea extends AbstractDomainObject {


    static constraints = {
        title unique: true, maxSize: 500, minSize: 5
        description unique: true, blank: false, maxSize: 50000, minSize: 5
    }

    static mapping = {
        id generator: 'assigned'
        version false
        description type: 'text'
        autoTimestamp true
    }

    @Override
    String toString() {
        return this.title
    }

    static hasMany = [tags: TagIdea, votes:IdeaVotes]
    static belongsTo = [status: Status, user:User]
    String title
    String description
    Status status = Status.findByName('New')
    User user
    Date dateCreated
}