package com.amondel.idsub

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IdeaServiceSpec extends Specification {

    IdeaService ideaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Idea(...).save(flush: true, failOnError: true)
        //new Idea(...).save(flush: true, failOnError: true)
        //Idea idea = new Idea(...).save(flush: true, failOnError: true)
        //new Idea(...).save(flush: true, failOnError: true)
        //new Idea(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //idea.id
    }

    void "test get"() {
        setupData()

        expect:
        ideaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Idea> ideaList = ideaService.list(max: 2, offset: 2)

        then:
        ideaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ideaService.count() == 5
    }

    void "test delete"() {
        Long ideaId = setupData()

        expect:
        ideaService.count() == 5

        when:
        ideaService.delete(ideaId)
        sessionFactory.currentSession.flush()

        then:
        ideaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Idea idea = new Idea()
        ideaService.save(idea)

        then:
        idea.id != null
    }
}
