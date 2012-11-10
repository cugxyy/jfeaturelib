package de.lmu.ifi.dbs.jfeaturelib.features;

import de.lmu.ifi.dbs.jfeaturelib.Progress;
import ij.process.ImageProcessor;
import java.util.EnumSet;

/**
 * Implementation of (three) Tamura features done by Marko Keuschnig & Christian Penz
 *
 * Changes by <br> <ul> <li> Ankit Jain (jankit87@gmail.com): histogram length in set string <li>
 * shen72@users.sourceforge.net: bugfixes in math (casting and brackets) </ul> Date: 28.05.2008 Time: 11:52:03
 */
public class Tamura extends AbstractFeatureDescriptor {

    @Override
    public void run(ImageProcessor ip) {
        de.lmu.ifi.dbs.jfeaturelib.features.lire.Tamura tamura = new de.lmu.ifi.dbs.jfeaturelib.features.lire.Tamura();
        firePropertyChange(Progress.START);
        tamura.extract(ip.getBufferedImage());
        addData(tamura.getData());
        firePropertyChange(Progress.END);
    }

    @Override
    public String getDescription() {
        return "Tamura filter";
    }

    @Override
    public EnumSet<Supports> supports() {
        EnumSet set = EnumSet.of(
                Supports.NoChanges,
                Supports.DOES_8C,
                Supports.DOES_8G,
                Supports.DOES_RGB);
        return set;
    }
}