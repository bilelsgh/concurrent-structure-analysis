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

 /**
  * Classes which allow to generate a random value according a distribution
  */
interface MyRandomGenerator {
    String name();
    double nextDouble();
    int nextInt(int bound);
    int nextInt();
  }
  
