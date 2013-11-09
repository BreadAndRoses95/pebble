/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Original work Copyright (c) 2009-2013 by the Twig Team
 * Modified work Copyright (c) 2013 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.node;

import com.mitchellbosecke.pebble.compiler.Compiler;
import com.mitchellbosecke.pebble.utils.TreeWriter;

public class NodePrint extends AbstractNode implements DisplayableNode{

	private final NodeExpression expression;

	public NodePrint(NodeExpression expression, int lineNumber) {
		super(lineNumber);
		this.expression = expression;
	}

	@Override
	public void compile(Compiler compiler) {
		
		// the compile form first casts the expression to an Object
		// just in case it's a primitive and we can't call toString
		compiler.raw("\n").write("builder.append(((Object)").subcompile(expression)
				.raw(").toString());");
	}
	
	@Override
	public void tree(TreeWriter tree) {
		tree.write("print").subtree(expression, true);
	}

}
