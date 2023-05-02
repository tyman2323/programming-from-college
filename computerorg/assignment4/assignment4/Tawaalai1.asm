.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword
;Ayman Tawaalai
;CSC3210
;Assignment 4
;This program converts the given code into assembly
.data
sum sdword 0
j sdword 12
i sdword 0
var1 sdword 3
var2 sdword 3
var3 sdword 0
.code
main proc
mov eax, i
mov ebx, var1
mov edx, var3

forloop:
	cmp eax, j
	jge complete
	cmp ebx, var3
	jg ifstatement
	elsestatement:
		add edx, eax
		jmp summer
	ifstatement:
		sub ebx, 1
	summer:
		add ebx, var2
		add ebx, edx
		mov sum, ebx
		dec j
		inc eax
		jmp forloop
	complete:
	
		
	INVOKE ExitProcess,0
main ENDP
END main


