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

import java.io.IOException;
import java.io.Writer;

import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.extension.NodeVisitor;
import com.mitchellbosecke.pebble.template.Block;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplateImpl;

public class BlockNode extends AbstractRenderableNode {

	private final BodyNode body;
	private String name;

	public BlockNode(int lineNumber, String name) {
		this(lineNumber, name, null);
	}

	public BlockNode(int lineNumber, String name, BodyNode body) {
		super(lineNumber);
		this.body = body;
		this.name = name;
	}

	@Override
	public void render(final PebbleTemplateImpl self, Writer writer, EvaluationContext context) throws PebbleException,
			IOException {

		Block block = new Block() {
			@Override
			public String getName() {
				return name;
			}

			@Override
			public void evaluate(Writer writer, EvaluationContext context) throws PebbleException, IOException {
				body.render(self, writer, context);

			}
		};

		self.registerBlock(block);
		self.block(name, context, false, writer);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public BodyNode getBody() {
		return body;
	}

	public String getName() {
		return name;
	}

}
