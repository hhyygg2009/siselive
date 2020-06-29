from tkinter import *
import tkinter.filedialog
import tkinter.colorchooser
import tkinter.messagebox
import tkinter.scrolledtext

app = Tk()
app.title('notepad')

textchanged = IntVar()
textchanged.set(0)

fn = ''

menu = Menu(app)


def Open():
    global fn
    if textchanged.get():
        ans = tkinter.messagebox.askyesno(title='save?', message='save before open?')
        if ans == 'tkinter.YES':
            Save()
    fn = tkinter.filedialog.askopenfilename()
    if fn:
        t.delete(0.0, tkinter.END)
    fp = open(fn, 'r')
    t.insert(tkinter.INSERT, ''.join(fp.readlines()))
    fp.close()
    textchanged.set(0)


def Save():
    fp = open(fn, 'rw')
    fp.write(t.get(0.0, tkinter.END))
    fp.close()


def Saveas():
    fn = tkinter.filedialog.askopenfilename()
    Save()

def close():
    app.quit()

def Copy():
    t.clipboard_clear()
    t.clipboard_append(t.selection_get())

def Cut():
    Copy()
    t.delete(tkinter.SEL_FIRST, tkinter.SEL_LAST)

def Delete():
    t.delete(tkinter.SEL_FIRST,tkinter.SEL_LAST)

def Paste():
    t.insert(t.clipboard_get())

fmenu = Menu(menu, tearoff=False)
fmenu.add_command(label="open", command=Open)
fmenu.add_command(label="save", command=Save)
fmenu.add_command(label="save_as", command=Saveas)
fmenu.add_separator()
fmenu.add_command(label="close",command=close)
emenu = Menu(menu, tearoff=False)
emenu.add_command(label="copy",command=Copy)
emenu.add_command(label="cut",command=Cut)
emenu.add_command(label="paste",command=Paste)
emenu.add_separator()
emenu.add_command(label="delete",command=Delete)
t = Text(app)
t.pack()
menu.add_cascade(label="file", menu=fmenu)
menu.add_cascade(label="edit", menu=emenu)

app.config(menu=menu)


def KeyPress(event):
    textchanged.set(1)


t.bind('<KeyPress>', KeyPress)

app.mainloop()