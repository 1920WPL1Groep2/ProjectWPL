//Auteur: Dario Kaczmarowski
package Model;

public class VrijeTabellen
{
/*    //Variabelen
    private String[] beheerdaad;
    private String[] bezonning;
    private String[] bladvorm;
    private String[] bloeiwijze;
    private String[] grondsoort;
    private String[] habitat;
    private String[] habitus;
    private String[] kleuren;
    private String[] levensduurConcurrentiekracht;
    private String[] maxBladGrootte;
    private String[] nectarwaarde;
    private String[] ontwikkelingssnelheid;
    private String[] pollenwaarde;
    private String[] ratioBloeiblad;
    private String[] reactieomgeving;
    private String[] sociabiliteit;
    private String[] spruitfenologie;
    private String[] strategie;
    private String[] vochtbehoefte;
    private String[] voedingsbehoefte;


    public VrijeTabellen()
    {
    }

    public void initialize()
    {
        //initialiseren van de array's
        beheerdaad = new String[GetSizeBeheerdaad];
        bezonning = new String[GetSizeBezonning];
        bladvorm = new String[GetSizeBladvorm];
        bloeiwijze = new String[GetSizeBloeiwijze];
        grondsoort = new String[GetSizeGrondsoort];
        habitat = new String[GetSizeHabitat];
        habitus = new String[GetSizeHabitus];
        kleuren = new String[GetSizeKleuren];
        levensduurConcurrentiekracht = new String[GetSizeLevensduurConcurrentiekracht];
        maxBladGrootte = new String[GetSizeMaxBladGrootte];
        nectarwaarde = new String[GetSizeNectarwaarde];
        ontwikkelingssnelheid = new String[GetSizeOntwikkelingssnelheid];
        pollenwaarde = new String[GetSizePollenwaarde];
        ratioBloeiblad = new String[GetSizeRatioBloeiblad];
        reactieomgeving = new String[GetSizeReactieomgeving];
        sociabiliteit = new String[GetSizeSociabiliteit];
        spruitfenologie = new String[GetSizeSpruitfenologie];
        strategie = new String[GetSizeStrategie];
        vochtbehoefte = new String[GetSizeVochtbehoefte];
        voedingsbehoefte = new String[GetSizeVoedingsbehoefte];

        //setten van de gegevens in de array's
        SetBeheerdaad();
        SetBezonning();
        SetBeheerdaad();
        SetBezonning();
        SetBladvorm();
        SetBloeiwijze();
        SetGrondsoort();
        SetHabitat();
        SetHabitus();
        SetKleuren();
        SetLevensduurConcurrentiekracht();
        SetMaxBladGrootte();
        SetNectarwaarde();
        SetOntwikkelingssnelheid();
        SetPollenwaarde();
        SetRatioBloeiblad();
        SetReactieomgeving();
        SetSociabiliteit();
        SetSpruitfenologie();
        SetStrategie();
        SetVochtbehoefte();
        SetVoedingsbehoefte();
    }

    // Get functies om de gegevens te lezen
    public String[] GetBeheerdaad(){return beheerdaad;}
    public String[] GetBezonning(){return bezonning;}
    public String[] GetBladvorm(){return bladvorm;}
    public String[] GetBloeiwijze(){return bloeiwijze;}
    public String[] GetGrondsoort(){return grondsoort;}
    public String[] GetHabitat(){return habitat;}
    public String[] GetHabitus(){return habitus;}
    public String[] GetKleuren(){return kleuren;}
    public String[] GetLevensduurConcurrentiekracht(){return levensduurConcurrentiekracht;}
    public String[] GetMaxBladGrootte(){return maxBladGrootte;}
    public String[] GetNectarwaarde(){return nectarwaarde;}
    public String[] GetOntwikkelingssnelheid(){return ontwikkelingssnelheid;}
    public String[] GetPollenwaarde(){return pollenwaarde;}
    public String[] GetRatioBloeiblad(){return ratioBloeiblad;}
    public String[] GetReactieomgeving(){return reactieomgeving;}
    public String[] GetSociabiliteit(){return sociabiliteit;}
    public String[] GetSpruitfenologie(){return spruitfenologie;}
    public String[] GetStrategie(){return strategie;}
    public String[] GetVochtbehoefte(){return vochtbehoefte;}
    public String[] GetVoedingsbehoefte(){return voedingsbehoefte;}

    // set functies om de variabelen in te vullen
    private void SetBeheerdaad()
    {
        for (int i = 0; i < GetSizeBeheerdaad; i++)
        {
            bezonning[i] = GetBeheerdaad;
        }
    }

    private void SetBezonning()
    {
        for (int i = 0; i < GetSizeBezonning; i++)
        {
            bezonning[i] = GetBezonning;
        }
    }

    private void SetBladvorm()
    {
        for (int i = 0; i < GetSizeBladvorm; i++)
        {
            bladvorm[i] = GetBladvorm;
        }
    }

    private void SetBloeiwijze()
    {
        for (int i = 0; i < GetSizeBloeiwijze; i++)
        {
            bloeiwijze[i] = GetBloeiwijze;
        }
    }

    private void SetGrondsoort()
    {
        for (int i = 0; i < GetSizeGrondsoort; i++)
        {
            grondsoort[i] = GetGrondsoort;
        }
    }

    private void SetHabitat()
    {
        for (int i = 0; i < GetSizeHabitat; i++)
        {
            habitat[i] = GetHabitat;
        }
    }

    private void SetHabitus()
    {
        for (int i = 0; i < GetSizeHabitus; i++)
        {
            Habitus[i] = GetHabitus;
        }
    }

    private void SetKleuren()
    {
        for (int i = 0; i < GetSizeKleuren; i++)
        {
            kleuren[i] = GetKleuren;
        }
    }

    private void SetLevensduurConcurrentiekracht()
    {
        for (int i = 0; i < GetSizeLevensduurConcurrentiekracht; i++)
        {
            levensduurConcurrentiekracht[i] = GetLevensduurConcurrentiekracht;
        }
    }

    private void SetMaxBladGrootte()
    {
        for (int i = 0; i < GetSizeMaxBladGrootte; i++)
        {
            maxBladGrootte[i] = GetMaxBladGrootte;
        }
    }

    private void SetNectarwaarde()
    {
        for (int i = 0; i < GetSizeNectarwaarde; i++)
        {
            nectarwaarde[i] = GetNectarwaarde;
        }
    }

    private void SetOntwikkelingssnelheid()
    {
        for (int i = 0; i < GetSizeOntwikkelingssnelheid; i++)
        {
            ontwikkelingssnelheid[i] = GetOntwikkelingssnelheid;
        }
    }

    private void SetPollenwaarde()
    {
        for (int i = 0; i < GetSizePollenwaarde; i++)
        {
            pollenwaarde[i] = GetPollenwaarde;
        }
    }

    private void SetRatioBloeiblad()
    {
        for (int i = 0; i < GetSizeRatioBloeiblad; i++)
        {
            ratioBloeiblad[i] = GetRatioBloeiblad;
        }
    }

    private void SetReactieomgeving()
    {
        for (int i = 0; i < GetSizeReactieomgeving; i++)
        {
            reactieomgeving[i] = GetReactieomgeving;
        }
    }

    private void SetSociabiliteit()
    {
        for (int i = 0; i < GetSizeSociabiliteit; i++)
        {
            sociabiliteit[i] = GetSociabiliteit;
        }
    }

    private void SetSpruitfenologie()
    {
        for (int i = 0; i < GetSizeSpruitfenologie; i++)
        {
            spruitfenologie[i] = GetSpruitfenologie;
        }
    }

    private void SetStrategie()
    {
        for (int i = 0; i < GetSizeStrategie; i++)
        {
            strategie[i] = GetStrategie;
        }
    }

    private void SetVochtbehoefte()
    {
        for (int i = 0; i < GetSizeVochtbehoefte; i++)
        {
            vochtbehoefte[i] = GetVochtbehoefte;
        }
    }

    private void SetVoedingsbehoefte()
    {
        for (int i = 0; i < GetSizeVoedingsbehoefte; i++)
        {
            voedingsbehoefte[i] = GetVoedingsbehoefte;
        }
    }*/
}
