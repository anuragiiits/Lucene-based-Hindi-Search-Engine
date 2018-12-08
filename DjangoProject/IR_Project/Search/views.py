from django.shortcuts import render
from django.conf import settings
from django.core.files.storage import FileSystemStorage

import os
import subprocess

# Create your views here.
def home(request):
    if request.method == 'GET':
        return render(request, 'home.html')


def upload_page(request):
    if request.method == 'POST':
        # print(request.POST)
        # print(request.FILES)
        myfile = request.FILES['file']
        fs = FileSystemStorage()
        filename = fs.save(myfile.name, myfile)
        return render(request, 'home.html')

def search_page(request):
    if request.method == 'GET':
        return render(request, 'home.html')

    if request.method == 'POST':
        text = request.POST.get('search_text')
        # s = "पास प्यासे के कुआँ आता नहीं है"
        # s1 = "rabindranath"
        op = subprocess.check_output('java -jar /home/anurag/Documents/django/IR_Project/Search/CompiledJarFile/SearchModel.jar '+text, shell=True).decode("UTF-8")
        op = str(op)
        lines = op.splitlines()
        count = int(lines[0].split(' ')[-1])
        print(count)
        contents = []
        if count >= 1:
            paths = [(lines[i][18:lines[i].find(',')],lines[i].split(' ')[-1]) for i in range(1, len(lines))]
            for i in range(1, len(lines)):
                path = lines[i][7:lines[i].find(',')].replace("\\","/")
                fp = open(path, 'r')
                contents.append([next(fp) for x in range(5)])
                fp.close()

        # print(contents)
        paths = list(zip(paths, contents))
        # print("Paths", paths)
        return render(request, 'results.html', {"results": paths})
