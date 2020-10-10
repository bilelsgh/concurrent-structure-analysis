
/*
 * Java Concurrent Data Structures - Analysis
 *
 * Copyright (c) 2020. Institut National des Sciences Appliquées de Lyon (INSA Lyon)
 * Copyright (c) 2020. Frédéric Le Mouël, Julien Ponge (INSA Lyon)
 * Copyright (c) 2020. Bilel SAGHROUCHNI (INSA Lyon)
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/
 */

import java.lang.Math.*;
import java.util.Random;


/** 
* <b>Class which computes a random value according a gaussian distribution with Random.nextGaussian() [pseudo-random]</b>
*<p>
* A gaussian generator is characterized by its mean and its standard deviation
*</p>
*
* @author Bilel SAGHROUCHNI
* @version 1.0 
*/
public class GaussianGeneratorVersionNextGaussian implements MyRandomGenerator{

    private double mean;
    private double lambda;

    /**
     * GaussianGeneratorVersionNextGaussian constructor.
     * 
     * @param mean
     *               Mean of the gaussian distribution
     * @param lambda
     *               Standard deviation of the gaussian distribution
     */
    public GaussianGeneratorVersionNextGaussian(double mean, double lambda){
        this.mean = mean;
        this.lambda = lambda;
    }

    /**
     * GaussianGeneratorVersionNextGaussian constructor.
     * 
     * When there is none parameter, the gaussian distribution is a standard normal distribution.
     */
    public GaussianGeneratorVersionNextGaussian(){
        mean = 0;
        lambda = 1;
    }

    /**
     * Compute a new random value using the method Random.nextGaussian()
     * @return num
     *          The new random value
     */
    @Override
    public double nextDouble(){
		Random generator = new Random();
		double num;

		num = generator.nextGaussian()*lambda + mean;
        return num;
    }

    /**
     * Display the method used
     * @return
     *          Name of the method used
     */
    @Override
    public String name(){
        return "## Gaussian Generator - version based on Random.nextGaussian() ##";
    }

    /**
     * Compute a new random value using a Random.nextGaussian()
     * @return num int
     *          The new random value
     */
    @Override
    public int nextInt(){
        return ( (int) Math.round( this.nextDouble() ) );
    }

    /**
     * Compute a new random value between 0 and bound using a Random.nextGaussian() 
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
        MyRandomGenerator ggNextGaussian = new GaussianGeneratorVersionNextGaussian();
        int times = 10;

        System.out.println(ggNextGaussian.name());
        for(int i = 0; i < times; i++){
            System.out.println(ggNextGaussian.nextInt(20));
        }
        System.out.println("\n");
    }

}
