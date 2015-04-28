package com.quoders.apps.androidbootstrap.rest.model;

import com.google.gson.annotations.Expose;

/**
 * Created by davidguerrerodiaz on 25/04/15.
 */

public class CommentItem {

    @Expose
    private Integer postId;
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String body;

    /**
     *
     * @return
     * The postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     *
     * @param postId
     * The postId
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public CommentItem withPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public CommentItem withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public CommentItem withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public CommentItem withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     *
     * @return
     * The body
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    public CommentItem withBody(String body) {
        this.body = body;
        return this;
    }
}
