.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword
;Ayman Tawaalai
;CSC 3210
;Assignment 3
;This program converts the code given in the document into asm
.data
var1 dword 10
var2 dword 11
var3 dword 12
.code
main proc
	mov eax, var2
	cmp var1, eax
	jg ifstatement
	cmp var3, eax
	jl ifstatement
	dec var1
	dec var2
	dec var3
	jmp breaker
	ifstatement:
	add eax, var3
	mov var1, eax
	breaker:
	INVOKE ExitProcess,0
main ENDP
END main


