package com.apress.controller;

import com.apress.domain.Vote;
import com.apress.service.PollService;
import com.apress.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class VoteController {


    @Autowired
    private VoteService voteService;
    private PollService pollService;

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        voteService.postVote(vote);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteService.getVotes(pollId);
    }

    @RequestMapping(value = "/polls/votes/{voteId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVote(@PathVariable Long voteId){
        voteService.deleteVotes(voteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/polls/{pollId}/votes/{voteId}", method =RequestMethod.GET)
    public Optional<Vote> getASingleVote(@PathVariable Long pollId){
        return voteService.getAVote(pollId);
    }

}