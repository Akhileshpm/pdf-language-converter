import PyPDF2 
import googletrans
from googletrans import Translator
#pdfFileObject = open('Summary.pdf', 'rb')
pdfReader = PyPDF2.PdfFileReader("./c.pdf")

#count = pdfReader.numPages

start = 0 #starting page number to convert
end = 0   #end page number to convert

str=""


for i in range(start,end+1):
    #page = pdfReader.getPage(i)
    #print(page.extractText())3
    str += pdfReader.getPage(i).extractText()

#creating object of Translator()
translator = Translator()

#detecting the pdf's language
dt1 = translator.detect(str)
#print(dt1)


translated = translator.translate(text1, src=dt1.lang, dest='en')
print(translated.text)
#result = translator.tranlsate(str,dest='ml')

#writing the translated text to another pdf
with open("text.pdf", "w") as f:
    f.write(translated)


