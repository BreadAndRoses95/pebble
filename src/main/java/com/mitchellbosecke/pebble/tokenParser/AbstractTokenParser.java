/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Copyright (c) 2014 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.tokenParser;

import com.mitchellbosecke.pebble.parser.Parser;

public abstract class AbstractTokenParser implements TokenParser {

    protected Parser parser;

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }

}
