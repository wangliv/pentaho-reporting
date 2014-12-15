/*
 * This program is free software; you can redistribute it and/or modify it under the
 *  terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 *  Foundation.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this
 *  program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 *  or from the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  Copyright (c) 2006 - 2009 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.reporting.engine.classic.testcases;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.pentaho.reporting.engine.classic.core.metadata.ExpressionMetaData;
import org.pentaho.reporting.engine.classic.core.metadata.ExpressionPropertyMetaData;
import org.pentaho.reporting.engine.classic.core.metadata.ExpressionRegistry;
import org.pentaho.reporting.engine.classic.core.testsupport.base.MetaDataValidationTestBase;

public class ExpressionMetaDataValidationTest extends MetaDataValidationTestBase<ExpressionMetaData>
{
  public ExpressionMetaDataValidationTest()
  {
  }

  @Test
  public void testMetaData() {
    ExpressionMetaData[] m = ExpressionRegistry.getInstance().getAllExpressionMetaDatas();
    List list = super.performTest(m);
    Assert.assertEquals(new ArrayList(), list);
  }

  protected void performTestOnElement(final ExpressionMetaData metaData)
  {
    final String typeName = metaData.getName();
    logger.debug("Processing " + typeName);

    try
    {
      final Object type = metaData.create();
    }
    catch (Exception e)
    {
      Assert.fail("metadata creation failed");

    }

    validate(metaData);

    for (ExpressionPropertyMetaData propertyDescription : metaData.getPropertyDescriptions())
    {
      validate(propertyDescription);
    }
  }
}
