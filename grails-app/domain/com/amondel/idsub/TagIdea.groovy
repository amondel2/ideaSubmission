package com.amondel.idsub

class TagIdea implements Serializable {

    def utilService = Utils.getInstance()
    private static final serialVersionUID = 1L

    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
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
        return "${this?.tag?.toString()} ${this.idea?.toString()}"
    }

    static belongsTo = [tag:Tag,idea:Idea]

    String id
    Tag tag
    Idea idea

}