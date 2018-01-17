package gruppe24.dendigitalerestaurantoplevelse;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.junit.Test;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Search;

/**
 * Created by Tobias Højsgaard on 06-01-2018.
 */

public class SearchTest {

    @Test
    public void test_search() throws Exception{
        Menu result = Backend.getInstance().search(Backend.getInstance().getMenu(), "Sashimi hamachi");
        for(String s: result.getDishesAsStrings()){
            System.out.println(s);
        }
        Assert.assertEquals("Sashimi hamachi", result.getDishes().get(0).getName());
    }

    @Test
    public void test_search2() throws Exception{
        Menu result = Backend.getInstance().search(Backend.getInstance().getMenu(), "grøntsag");
        for(String s: result.getDishesAsStrings()){
            System.out.println(s);
        }
        Assert.assertEquals("Broccoli", result.getDishes().get(0).getName());
    }



}
