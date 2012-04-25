/*
 * Copyright 2011 Kindleit Technologies. All rights reserved. This file, all
 * proprietary knowledge and algorithms it details are the sole property of
 * Kindleit Technologies unless otherwise specified. The software this file
 * belong with is the confidential and proprietary information of Kindleit
 * Technologies. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Kindleit.
 */


package play;

import java.util.Date;

import org.junit.Test;

import play.ConditionalThunk;
import play.EnumThunk;
import play.InterfaceThunk;
import play.Thunk;

/** ThunkTest is responsible of
 * @author rhansen@kitsd.com
 */
public class ThunkTest {

  /**
   * Test method for {@link play.Thunk#get()}.
   */
  @Test
  public void testConditionalGet() {
    final Thunk<Date> ct = new ConditionalThunk<Date>();
    thunkTest(ct);
  }

  @Test
  public void testInterfaceGet() {
    final Thunk<Date> ct = new InterfaceThunk<Date>();
    thunkTest(ct);
  }

  @Test
  public void testEnumGet() {
    final Thunk<Date> ct = new EnumThunk<Date>();
    thunkTest(ct);
  }

  private void thunkTest(final Thunk<Date> ct) {
    int i = 0;
    final long startTime = System.nanoTime();
    while (i++ < Integer.MAX_VALUE) {
      ct.get();
    }
    final long estimatedElapse = System.nanoTime() - startTime;
    System.out.println(ct.toString() + " test took: " + estimatedElapse);

  }

}

