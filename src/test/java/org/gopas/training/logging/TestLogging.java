/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gopas.training.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author SedaQ
 */
public class TestLogging {

    public static final Logger LOG = LoggerFactory.getLogger(TestLogging.class);

    public static void main(String[] args) {
        LOG.debug("Entering application.");

        LOG.debug("Exiting application.");
    }

}
