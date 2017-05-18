package nameInverter;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jojonari on 2017. 5. 18..
 */
class NameInverter {

    private String name;

    private String formatMultiElementName(List<String> names) {
        String postNominal = "";
        if (names.size() > 2)
            postNominal = getPostNominal(names);
        return postNominal;
    }

    private boolean isHonorific(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }

    private String getPostNominal(List<String> names) {
        List<String> postNominals = names.subList(2, names.size());
        return Joiner.on(" ").join(postNominals);
    }


    public String inverter(String name) {
        this.name = name;
        if (name == null || name.isEmpty())
            return "";
        else
            return formatName(removeHonorific(splitNmaes(name)));
    }

    private String formatName(List<String> names) {
        if (names.size() == 1)
            return names.get(0);

        String postNominal = formatMultiElementName(names);
        return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
    }

    private List<String> removeHonorific(List<String> names) {
        if (names.size() > 1 && isHonorific(names))
            names.remove(0);
        return names;
    }

    private ArrayList<String> splitNmaes(String name) {
        return new ArrayList<String>(Arrays.asList(name.trim().split("\\s+")));
    }
}
