package com.amondel.idsub

class Idea implements Serializable {

    def utilService = Utils.getInstance()
    private static final serialVersionUID = 1L

    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
        description type: 'text'
    }

    def beforeValidate() {
        if(!id || id.equals(null)) {
            id  = utilService.idGenerator()
        }
    }

    def beforeInsert() {
        if(!id || id.equals(null)) {
            id  = utilService.idGenerator()
        }
    }

    @Override
    public String toString(){
        return this.title
    }

    static hasMany = [tags:TagIdea]
    static belongsTo = [status:Status]
    String title
    String description
    Status status
    String id
}