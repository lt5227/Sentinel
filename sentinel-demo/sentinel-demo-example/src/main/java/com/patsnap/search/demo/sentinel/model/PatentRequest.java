package com.patsnap.search.demo.sentinel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatentRequest implements Serializable {

    protected String query;

    protected String userId;
}
