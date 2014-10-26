/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Copyright (c) 2014 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.loader;

import java.io.Reader;

import com.mitchellbosecke.pebble.error.LoaderException;

public interface Loader {

    public Reader getReader(String templateName) throws LoaderException;

    public void setCharset(String charset);

    public void setPrefix(String prefix);

    public void setSuffix(String suffix);

}
