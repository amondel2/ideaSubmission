package com.amondel.idsub

class IdeaVotes extends AbstractDomainObject {
    static constraints = {
        idea unique: 'user'
    }
    static mapping = {
        id generator: 'assigned'
        version false
    }
    static belongsTo = [idea:Idea,user:User]

    Idea idea
    User user

    @Override
    String toString() {
        return "${this.idea.toString()} ${this.user.toString()}"
    }
}