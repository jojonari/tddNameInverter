package nameInverter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NameInverterTest {

    private NameInverter nameInverter =new NameInverter();

    @Test
    public void NameInverterTest() throws Exception {

        assertThat(nameInverter.inverter(null), is(""));
        assertThat(nameInverter.inverter(""), is(""));
        assertThat(nameInverter.inverter("name"), is("name"));
        assertThat(nameInverter.inverter("first last"), is("last, first"));
        assertThat(nameInverter.inverter("   name   "), is("name"));
        assertThat(nameInverter.inverter("first     last"), is("last, first"));
        assertThat(nameInverter.inverter("Mr. first last"), is("last, first"));
        assertThat(nameInverter.inverter("Mrs. first last"), is("last, first"));
        assertThat(nameInverter.inverter("first last SR."), is("last, first SR."));
        assertThat(nameInverter.inverter("first last BS. Phd."), is("last, first BS. Phd."));
        assertThat(nameInverter.inverter("   Robert Martin II esq."), is("Martin, Robert II esq."));

    }

}
