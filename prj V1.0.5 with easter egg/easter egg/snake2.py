import turtle
import time
import random

# Impostazioni del gioco
larghezza, altezza = 500, 500
dimensione_segmento = 20
ritardo = 0.1

# Inizializzazione della finestra di gioco
finestra = turtle.Screen()
finestra.title("Snake")
finestra.bgcolor("white")
finestra.setup(width=larghezza, height=altezza)
finestra.tracer(0)

# Testa del serpente
testa = turtle.Turtle()
testa.speed(0)
testa.shape("square")
testa.color("black")
testa.penup()
testa.goto(0, 0)
in_movimento = True  # Nuova variabile per indicare se il serpente è in movimento

# Cibo per il serpente
cibo = turtle.Turtle()
cibo.speed(0)
cibo.shape("circle")
cibo.color("red")
cibo.penup()
cibo.goto(0, 100)

# Segmenti del corpo del serpente
segmenti = []

# Funzioni di movimento
def sali():
    global in_movimento
    if not in_movimento:
        in_movimento = True
        testa.direction = "up"

def scendi():
    global in_movimento
    if not in_movimento:
        in_movimento = True
        testa.direction = "down"

def sinistra():
    global in_movimento
    if not in_movimento:
        in_movimento = True
        testa.direction = "left"

def destra():
    global in_movimento
    if not in_movimento:
        in_movimento = True
        testa.direction = "right"

def muovi():
    if in_movimento:
        if testa.direction == "up":
            y = testa.ycor()
            testa.sety(y + dimensione_segmento)

        if testa.direction == "down":
            y = testa.ycor()
            testa.sety(y - dimensione_segmento)

        if testa.direction == "left":
            x = testa.xcor()
            testa.setx(x - dimensione_segmento)

        if testa.direction == "right":
            x = testa.xcor()
            testa.setx(x + dimensione_segmento)

# Collegamento dei tasti alle funzioni di movimento
finestra.listen()
finestra.onkeypress(sali, "Up")
finestra.onkeypress(scendi, "Down")
finestra.onkeypress(sinistra, "Left")
finestra.onkeypress(destra, "Right")

# Ciclo principale del gioco
while True:
    finestra.update()

    # Verifica collisione con il bordo della finestra
    if (
        testa.xcor() > larghezza / 2
        or testa.xcor() < -larghezza / 2
        or testa.ycor() > altezza / 2
        or testa.ycor() < -altezza / 2
    ):
        time.sleep(1)
        testa.goto(0, 0)
        in_movimento = False  # Fermiamo il serpente quando colpisce il bordo

        # Nascondi i segmenti del corpo
        for segmento in segmenti:
            segmento.goto(1000, 1000)

        # Cancella la lista dei segmenti
        segmenti.clear()

    # Verifica collisione con il cibo
    if testa.distance(cibo) < dimensione_segmento:
        x = random.randint(
            -larghezza / 2 + dimensione_segmento,
            larghezza / 2 - dimensione_segmento,
        )
        y = random.randint(
            -altezza / 2 + dimensione_segmento,
            altezza / 2 - dimensione_segmento,
        )
        cibo.goto(x, y)

        # Aggiungi un segmento al corpo del serpente
        nuovo_segmento = turtle.Turtle()
        nuovo_segmento.speed(0)
        nuovo_segmento.shape("square")
        nuovo_segmento.color("black")
        nuovo_segmento.penup()
        segmenti.append(nuovo_segmento)

    # Muovi i segmenti del corpo in ordine inverso
    for i in range(len(segmenti) - 1, 0, -1):
        x = segmenti[i - 1].xcor()
        y = segmenti[i - 1].ycor()
        segmenti[i].goto(x, y)

    # Muovi il primo segmento dove si trova la testa
    if len(segmenti) > 0:
        x = testa.xcor()
        y = testa.ycor()
        segmenti[0].goto(x, y)

    muovi()

    # Verifica collisione con il corpo del serpente
    for segmento in segmenti:
        if segmento.distance(testa) < dimensione_segmento:
            time.sleep(1)
            testa.goto(0, 0)
            in_movimento = False  # Fermiamo il serpente quando colpisce il corpo

            # Nascondi i segmenti del corpo
            for segmento in segmenti:
                segmento.goto(1000, 1000)

            # Cancella la lista dei segmenti
            segmenti.clear()

    time.sleep(ritardo)
