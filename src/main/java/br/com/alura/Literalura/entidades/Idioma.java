package br.com.alura.Literalura.entidades;

public enum Idioma {
    EN("en"),
    PT("pt"),
    FR("fr"),
    ES("es");

    public String traducao;

    Idioma(String traducao) {
        this.traducao = traducao;
    }

    public static Idioma deGutendex(String traducao) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.traducao.equalsIgnoreCase(traducao)) {
                return idioma;
            }
        }
        return null;
    }
}
