
/*
 * Java Concurrent Data Structures - Analysis
 *
 * Copyright (c) 2020. Institut National des Sciences Appliquées de Lyon (INSA Lyon)
 * Copyright (c) 2020. Frédéric Le Mouël, Julien Ponge (INSA Lyon)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/
 */

import java.lang.Math.*;
import java.util.Random;
import java.security.SecureRandom;



/** 
* <b>Class which computes a random value according a gaussian distribution with Math.random() [pseudo-random]</b>
*<p>
* A gaussian generator is characterized by its mean and its standard deviation
*</p>
*
* @author Bilel SAGHROUCHNI
* @version 1.0 
*/
public class GaussianGeneratorVersionRand implements MyRandomGenerator{

    private double mean;
    private double lambda;

    /**
     * GaussianGeneratorVersionRand constructor.
     * 
     * @param mean
     *               Mean of the gaussian distribution
     * @param lambda
     *               Standard deviation of the gaussian distribution
     */
    public GaussianGeneratorVersionRand(double mean, double lambda){
        this.mean = mean;
        this.lambda = lambda;
    }

    /**
     * GaussianGeneratorVersionRand constructor.
     * 
     * When there is none parameter, the gaussian distribution is a standard normal distribution.
     */
    public GaussianGeneratorVersionRand(){
        mean = 0;
        lambda = 1;
    }

    /**
     * Compute a new random value using the method Math.random()
     * @return num
     *          The new random value
     */
    @Override
    public double nextDouble(){
        double u1, u2, value;

		u1 = Math.random();
		u2 = Math.random();
		value = (Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2) * lambda + mean);

        return value;
    }

    /**
     * Display the method used
     * @return
     *          Name of the method used
     */
    @Override
    public String name(){
        return "## Gaussian Generator - version based on Math.random() ##";
    }

    /**
     * Compute a new random value using a Math.random()
     * @return num int
     *          The new random value
     */
    @Override
    public int nextInt(){
        return ( (int) Math.round( this.nextDouble() ) );
    }

    /**
     * Compute a new random value between 0 and bound using a Math.random() 
     * 
     * @param bound
     *              Maxium value generated
     * @return num int
     *          The new random value
     */
    @Override
    public int nextInt(int bound){
        int res;
        res = nextInt();
        this.mean = bound/2;
        this.lambda = bound/6.18;

        res = nextInt();
        while(res > bound || res < 0){
            res = nextInt();
        }
        return res;
    }

    //Test of the method
    public static void main(String[] args) throws Exception {
        MyRandomGenerator ggRand = new GaussianGeneratorVersionRand(10,3);

        System.out.println(ggRand.name());
        for(int i = 0; i < 10; i++){
            System.out.println(ggRand.nextInt());
        }
        System.out.println("\n");
    }    
}