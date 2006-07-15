/*
 * Copyright (C) [2004, 2005, 2006], Hyperic, Inc.
 * This file is part of SIGAR.
 * 
 * SIGAR is free software; you can redistribute it and/or modify
 * it under the terms version 2 of the GNU General Public License as
 * published by the Free Software Foundation. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

package org.hyperic.sigar.test;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.ProcStat;

public class TestProcStat extends SigarTestCase {

    public TestProcStat(String name) {
        super(name);
    }

    public void testCreate() throws Exception {
        Sigar sigar = getSigar();

        ProcStat stat = sigar.getProcStat();

        long[] pids = sigar.getProcList();

        //oh-no a racing condition!
        //possible for this test to fail under normal 
        //conditions if the process table changes in between.
        //if this is a real problem, can just change to:
        //assertTrue(stat.getTotal() > 1);
        assertTrue(pids.length == stat.getTotal());
    }
}
