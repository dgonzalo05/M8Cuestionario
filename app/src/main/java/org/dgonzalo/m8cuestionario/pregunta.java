package org.dgonzalo.m8cuestionario;

public class pregunta {

    private int preguntaId;
    private boolean respPregunta;
    private int idimage;



    public pregunta(int idPreg, boolean resPreg, int idimage){
        preguntaId = idPreg;
        respPregunta = resPreg;
        this.idimage = idimage;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public boolean isRespPregunta() {
        return respPregunta;
    }

    public void setRespPregunta( boolean respPregunta) {
        this.respPregunta = respPregunta;
    }

    public int getImage() { return idimage; }

    public void setImage(int idimage) { this.idimage = idimage; }
}
